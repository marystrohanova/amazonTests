package amazon;
import org.testng.annotations.Test;

import framework.FrameworkBase;
import framework.page.AmazonFrontPage;
import framework.page.AmazonItemPage;
import framework.page.AmazonResultPage;
import framework.page.AmazonSignInPage;
import framework.page.AmazonUserPage;

public class AmazonTest extends FrameworkBase{
	
	@Test
	public void signInTest(){
		String email = "some.valid.email";
		String password = "somePassword";
		String name = "Println";
		
		AmazonFrontPage frontPage = new AmazonFrontPage();
		frontPage.open();
		frontPage.assertPageLoaded();
		frontPage.hoverAccountBtn();
		frontPage.clickSignInBtn();
		
		AmazonSignInPage signInPage = new AmazonSignInPage();
		signInPage.signInWith(email, password);
		
		frontPage.assertUserSignedIn(name);
		frontPage.hoverAccountBtn();
		frontPage.goToUserAccount();
		
		AmazonUserPage userPage = new AmazonUserPage();
		userPage.goToChangeAccStngs();
		
		String userName = userPage.getUserName();
		System.out.println("User name: " + userName);
		
	}
	
	@Test
	public void searchPopcornTest(){
		String popper = "Stove popcorn popper";
		String salt = "popcorn salt";
		
		AmazonFrontPage frontPage = new AmazonFrontPage();
		frontPage.open();
		frontPage.assertPageLoaded();
		frontPage.searchFor(popper);
		
		AmazonResultPage resultPage = new AmazonResultPage();
		resultPage.assertFirstResultHasPrime();
		resultPage.goToItem();
		
		AmazonItemPage itemPage = new AmazonItemPage();
		itemPage.addToShopingCart();
		
		frontPage.searchFor(salt);
		resultPage.assertFirstResultHasBestSeller();
		resultPage.goToItem();
		itemPage.addToShopingCart();
		
	}
}
