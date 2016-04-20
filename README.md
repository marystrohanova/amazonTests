# amazonTests
basic framework

Automated Tests:

Test #1
- Open http://www.amazon.com 
- Validate the page has loaded.
- Sign In into the provided account
- Hover the Hello. Sign In button
- Click the Sign In button in the overlay menu.
- Validate the login was successful
- Navigate to Your Account link
- Click the Change Account Settings link
- Find the name under which the account was registered.
- Print the name in the console

Test #2
- Open http://www.amazon.com
- Validate the page has loaded.
- Search for Stove popcorn popper
- Validate the first result has Prime shipping
- Add this product to the Shopping Cart
- Search for popcorn salt
- Validate the first result is #1 Best Seller
- Add this product to the Shopping Cart
- Verify that your shopping cart has two products

__________________________________________________
Using:
- java
- Selenium Web-driver
- page objects
- maven
- testNG
