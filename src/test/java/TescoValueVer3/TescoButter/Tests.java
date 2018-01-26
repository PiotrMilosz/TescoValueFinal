package TescoValueVer3.TescoButter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends AppiumDriverBase {


    @Test(priority = 1, description = "Przejście na portal eZakupy z Tesco.pl")
    public void s1_goTest() {

        mainT.openPage();

        //////	Zamiast if else mozesz uzyc asercji z testng:
//        if (mainT.validateMainpage()) {
//            System.out.println("Pass");
//        } else {
//            System.out.println("Failed");
//        }
        Assert.assertTrue(mainT.validateMainpage());

        mainT.testGoToEZakupy();
    }

    @Test(priority = 2, description = "Wyszukiwanie pieluszki")
    public void s2_goButterDepartement() {

        eZakupy.goToZakupy();
        eZakupy.search("pieluszki pampers");
        eZakupy.priceVerifier();
        eZakupy.searchClear();
       


    }
    @Test(priority=3,description="Wyszukiwanie sok")
    public void cheapestOne() {
    	
    	
        eZakupy.search("sok jabłkowy");
        eZakupy.priceVerifier();
        eZakupy.searchClear();
    }


}
