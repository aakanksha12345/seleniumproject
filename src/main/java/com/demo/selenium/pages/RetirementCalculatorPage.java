package com.demo.selenium.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.selenium.base.BaseTest;
public class RetirementCalculatorPage  {
	
	private WebDriver driver;

    public RetirementCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://www.securian.com/insights-tools/retirement-calculator.html");
    }

    public void enterCurrentAge(String age) {
        driver.findElement(By.id("current-age")).sendKeys(age);
    }

    public void enterRetirementAge(String age) {
        driver.findElement(By.id("retirement-age")).sendKeys(age);
    }

    public void enterCurrentIncome(String income) {
        WebElement currentIncomeField = driver.findElement(By.id("current-income"));
        focusAndClearField(currentIncomeField);
        currentIncomeField.sendKeys(income);
    }

    public void enterSpouseIncome(String income) {
        WebElement spouseIncome = driver.findElement(By.id("spouse-income"));
        focusAndClearField(spouseIncome);
        spouseIncome.sendKeys(income);
    }

    public void enterCurrentRetirementSavings(String savings) {
        WebElement currentRetirementSavings = driver.findElement(By.id("current-total-savings"));
        focusAndClearField(currentRetirementSavings);
        currentRetirementSavings.sendKeys(savings);
    }

    public void enterCurrentRetirementContribution(String contribution) {
        WebElement currentRetirementContribution = driver.findElement(By.id("current-annual-savings"));
        currentRetirementContribution.sendKeys(contribution);
    }

    public void setAnnualContributionRate(String rate) {
        WebElement annualContributionRate = driver.findElement(By.id("savings-increase-rate"));
        String scriptClear = "arguments[0].value = '';";
        ((JavascriptExecutor) driver).executeScript(scriptClear, annualContributionRate);
        String scriptSet = "arguments[0].value = arguments[1];";
        ((JavascriptExecutor) driver).executeScript(scriptSet, annualContributionRate, rate);
    }

    public void clickIncludeSocialSecurityBenefits() {
        WebElement yesOption = driver.findElement(By.id("yes-social-benefits"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", yesOption);
    }

    public void selectMaritalStatus(String status) {
        WebElement maritalStatusRadioButton = driver.findElement(By.id(status));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", maritalStatusRadioButton);
    }

    public void enterSocialSecurityOverrideAmount(String amount) {
        WebElement socialSecurityOverrideAmount = driver.findElement(By.id("social-security-override"));
        focusAndClearField(socialSecurityOverrideAmount);
        socialSecurityOverrideAmount.sendKeys(amount);
    }

    public void clickDefaultValuesModal() {
        WebElement defCal = driver.findElement(By.xpath("//a[@data-target='#default-values-modal']"));
        defCal.click();
    }

    public void enterAdditionalIncome(String income) {
        WebElement otherIncome = driver.findElement(By.id("additional-income"));
        focusAndClearField(otherIncome);
        otherIncome.sendKeys(income);
    }

    public void enterRetirementDuration(String years) {
        WebElement retireYear = driver.findElement(By.id("retirement-duration"));
        retireYear.sendKeys(years);
    }

    public void togglePostRetirementIncome() {
        WebElement postRetireIncome = driver.findElement(By.id("include-inflation"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", postRetireIncome);
        
    }

    public void enterAnnualRetirementIncome(String income) {
        WebElement annualRetireIncome = driver.findElement(By.id("retirement-annual-income"));
        annualRetireIncome.sendKeys(income);
    }

    public void enterPreRetirementROI(String roi) {
        WebElement preRetireRoi = driver.findElement(By.id("pre-retirement-roi"));
        preRetireRoi.sendKeys(roi);
    }

    public void enterPostRetirementROI(String roi) {
        WebElement postRetireRoi = driver.findElement(By.id("post-retirement-roi"));
        postRetireRoi.sendKeys(roi);
    }

    public void clickSave() {
        WebElement save = driver.findElement(By.xpath("//form[@id='default-values-form']//button[@class='dsg-btn-primary btn-block']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);
    }

    public void clickSubmit() {
        WebElement submit = driver.findElement(By.xpath("//button[@data-tag-id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -100);");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
    }

    private void focusAndClearField(WebElement element) {
        String script = "var input = arguments[0];" +
                        "input.focus();" +
                        "input.setSelectionRange(0, input.value.length);" +
                        "input.value = '';";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }
}


