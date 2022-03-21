package usercredentials.base.display;

import usercredentials.base.engine.UserCredentials;
import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;  


public class UserCredentialsDisplay extends JFrame implements ActionListener{


    protected JPanel mainPanel;   

    protected JLabel userNameLabel;
    protected JLabel passwordLabel;
    protected JLabel successLabel;

    protected JTextField userNameField;
    protected JPasswordField passwordPField = new JPasswordField(20);
    protected JTextField passwordTField = new JTextField(20);

    protected JCheckBox showPasswordCheckBox;
    protected JButton loginButton;

    protected Object buttonPressed;

    protected String username = "Michael";
    protected String password = "Password";
    protected String name; 
    protected String pass; 
    protected int loginAttempts = 5;

    

    public UserCredentialsDisplay(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainPanel());
        setBounds(100, 100, 350, 200);

        loginButton.addActionListener(this);
        showPasswordCheckBox.addActionListener(this);
        System.out.println("login attempts: " + loginAttempts);

        setVisible(true); 
    }


    @Override
    public void actionPerformed(ActionEvent e){
       
        buttonPressed = e.getSource();
        name = userNameField.getText();
        name = name.trim();
        UserCredentials login = new UserCredentials(username, password);

    try {
    
        if(showPasswordCheckBox.isSelected()){

            mainPanel.remove(passwordPField);
            mainPanel.validate();
            mainPanel.repaint(); 
            passwordTField.setBounds(100, 50, 165, 25);
            mainPanel.add(passwordTField);
            mainPanel.validate();
            mainPanel.repaint();
            

        }  if(!showPasswordCheckBox.isSelected()){

            mainPanel.remove(passwordTField);
            mainPanel.validate();
            mainPanel.repaint();
            passwordPField.setBounds(100, 50, 165, 25);
            mainPanel.add(passwordPField);
            mainPanel.validate();
            mainPanel.repaint();

        }
    } catch (Exception a) {
        System.out.println("enter valid password");
    }

        if(buttonPressed == loginButton){
            try {                   
                if (login.validUsername(name) && login.validPassword(returnPass())){
                    successLabel.setText("Login Sucessful");
                    successLabel.setForeground( (new Color(20, 138, 4)));
                    mainPanel.validate();
                    mainPanel.repaint();
                    loginAttempts = 3;
                                  
                }

                if (!login.validUsername(name)){
                    successLabel.setText("Username does not exist");
                    successLabel.setForeground(Color.RED);
                    mainPanel.validate();
                    mainPanel.repaint();

                   
                }

                if (login.validUsername(name) && !login.validPassword(returnPass())){
                    successLabel.setText("Incorrect Password");
                    successLabel.setForeground(Color.RED);
                    mainPanel.validate();
                    mainPanel.repaint();
                    loginAttempts--;
                    System.out.println("login attempts: " + loginAttempts);
                   
                }

                if (loginAttempts == 1) {
                    successLabel.setText("This is your final attempt");
                    successLabel.setForeground(Color.RED);
                    mainPanel.validate();
                    mainPanel.repaint();
                }
                    
                if (loginAttempts <= 0) {
                    successLabel.setText("You are locked out");
                    successLabel.setForeground(Color.RED);
                    mainPanel.validate();
                    mainPanel.repaint();
                }

                    
                } catch (Exception b) {
                    successLabel.setText("enter a valid username and password");
                    successLabel.setBounds(10, 140, 300, 25);
                    successLabel.setForeground(Color.RED);
                    mainPanel.validate();
                    mainPanel.repaint();
                }

        }
    
    }

    public String returnPass(){
        if(showPasswordCheckBox.isSelected()){
            pass = passwordTField.getText();
            System.out.println("checking : " + pass);;
            return pass;
        }
       else {
            pass = new String(passwordPField.getPassword());
            System.out.println("checking : " + pass);
            return pass;
        }
        
    }

    public JPanel mainPanel(){
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        
        userNameLabel = new JLabel("Username:");
        userNameLabel.setBounds(10, 20, 165, 25);
        mainPanel.add(userNameLabel);

        userNameField = new JTextField(20);
        userNameField.setBounds(100, 20, 165, 25);
        mainPanel.add(userNameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        mainPanel.add(passwordLabel);

        passwordPField.setBounds(100, 50, 165, 25);
        mainPanel.add(passwordPField);

        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBounds(100, 80, 200, 25);
        mainPanel.add(showPasswordCheckBox);

        loginButton = new JButton("Login");
        loginButton.setBounds(200, 110, 80, 25);
        mainPanel.add(loginButton);
        
        successLabel = new JLabel("");
        successLabel.setBounds(10, 110, 300, 25);
        mainPanel.add(successLabel);

        return mainPanel;

    }

}
