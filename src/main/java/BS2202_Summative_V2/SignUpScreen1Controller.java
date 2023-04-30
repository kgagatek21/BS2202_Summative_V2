package BS2202_Summative_V2;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class SignUpScreen1Controller
{
    public TextField usernameTextField;
    public TextField fullNameTextField;
    private String loggedinUser;

    public void receiveInformation(String information)
    {
        loggedinUser = information;
    }

    public void handleNextButtonAction(ActionEvent event) throws Exception
    {

    }
}
