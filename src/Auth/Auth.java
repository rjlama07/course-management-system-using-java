package Auth;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Connector.DatabaseConnector;
import Controller.ChangeData;
import Exceptions.InvalidEmail;
import Exceptions.PasswordDonotMatch;
import Exceptions.UserAlreadyExist;
import Exceptions.UserNotFound;
import Models.TotalData;
import Models.Usermodel;
import Pages.LoginPage;
import Pages.MainDashboard;
import Validator.Valid;




public class Auth {
	DatabaseConnector dc;
	public Auth(DatabaseConnector dc){
		this.dc=dc;
	}
	
    public void login(String username,String password, JPanel mainPanel,JFrame frame){
    	Usermodel user=new Usermodel();
    	ChangeData cd=new ChangeData(dc);
        if(username.isEmpty() && password.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please input usename or password");

				}
				else{
					try {
						
						String query="SELECT * FROM `users` WHERE email=? and password=?";
						PreparedStatement pst=dc.pst(query);
						pst.setString(1, username);
						pst.setString(2,password);
						ResultSet rs=pst.executeQuery();
						if(rs.next())
						{
							user.setRole(rs.getString("role"));
							user.setFirstName(rs.getString("firstname"));
							user.setPassword(rs.getString("password"));
							user.setEmail(rs.getString("email"));
							user.setLastName(rs.getString("lastname"));
							mainPanel.setVisible(false);
						   final TotalData totalData=cd.totalUsers();
							new MainDashboard(frame,user,dc,totalData);
							if(user.getRole().equals("student"))
							{
								
								JOptionPane.showMessageDialog(null, "Login in as Student");
								 
							}
							else if(user.getRole().equals("teacher"))
							{
								
								JOptionPane.showMessageDialog(null, "Login in as Teacher");
									
							}
							else if(user.getRole().equals("admin"))
							{
								
								JOptionPane.showMessageDialog(null, "Welcome admin");
							}
							else 
							{
								JOptionPane.showMessageDialog(null, "Something went wrong!!");
							}
							
						}
						else
						{
							throw new UserNotFound("User not found");
						}
						
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
    }


	public void Signup(Usermodel user,JFrame frame,JPanel panel,String course){
		Valid validator=new Valid();
		try{
			if (!validator.checkEmail(user.getEmail()))
				{
					throw new InvalidEmail("Invalid Email! enter valid email");

				}
				else if (validator.checkPassword(user.getPassword()) && user.getPassword().equals(user.getCpassword())) {
					try {
						String query = "INSERT INTO `users`(`email`, `password`, `role`,`firstname`,`lastname`,`course_enrolled`) VALUES (?,?,?,?,?,?)";
						String query1 = "SELECT role FROM `users` WHERE email=?";
						PreparedStatement pst1=dc.pst(query1);
				
						pst1.setString(1, user.getEmail());
						ResultSet rs = pst1.executeQuery();
						if (rs.next()) {
							throw new UserAlreadyExist("User Already Exist");
						} else {
							PreparedStatement pst;
							pst = dc.pst(query);
							pst.setString(1, user.getEmail());
							pst.setString(2, user.getPassword());
							pst.setString(3, user.getRole());
							pst.setString(4, user.getFirstName());
							pst.setString(5, user.getLastName());
							pst.setString(6,course);
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "You are registered.Login to continue");
							new LoginPage(frame,dc);
							panel.setVisible(false);
						}
						
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());

					}
				} else if (!validator.checkPassword(user.getPassword())) {
					 throw new PasswordDonotMatch("Password must have one special character,uppercase, lowercase and must be atleast 8 characters ");
				} else if (!user.getPassword().equals(user.getCpassword())) {
					throw new PasswordDonotMatch("Password do not match");
				}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
    
}
