package Controller;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class Showpassword {
	public void showPassword(JCheckBox checkBox,JPasswordField passwordField) {
		if(!checkBox.isSelected())
		{
			
			passwordField.setEchoChar('*');
		}
		else
		{
			passwordField.setEchoChar((char) 0);
		
	}
}
	public void showPassword(JCheckBox checkBox,JPasswordField passwordField,JPasswordField p1) {
		if(!checkBox.isSelected())
		{
			
			passwordField.setEchoChar('*');
			p1.setEchoChar('*');
		}
		else
		{
			passwordField.setEchoChar((char) 0);
			p1.setEchoChar((char) 0);
		
	}
}
	public void showPassword(JCheckBox checkBox,JPasswordField passwordField,JPasswordField p1,JPasswordField p2) {
		if(!checkBox.isSelected())
		{
			
			passwordField.setEchoChar('*');
			p1.setEchoChar('*');
			p2.setEchoChar('*');
			
		}
		else
		{
			passwordField.setEchoChar((char) 0);
			p1.setEchoChar((char) 0);
			p2.setEchoChar((char) 0);
		
	}
}
}