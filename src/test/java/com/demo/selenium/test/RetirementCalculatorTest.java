package com.demo.selenium.test;

import org.testng.annotations.Test;

import com.demo.selenium.base.BaseTest;
import com.demo.selenium.pages.RetirementCalculatorPage;

public class RetirementCalculatorTest extends BaseTest{
	@Test
    public void testRetirementCalculator() throws InterruptedException {
        RetirementCalculatorPage calculatorPage = new RetirementCalculatorPage(driver);
        calculatorPage.openPage();

        calculatorPage.enterCurrentAge("40");
        calculatorPage.enterRetirementAge("68");
        calculatorPage.enterCurrentIncome("100000");
        calculatorPage.enterSpouseIncome("75000");
        calculatorPage.enterCurrentRetirementSavings("500000");
        calculatorPage.enterCurrentRetirementContribution("10");
        calculatorPage.setAnnualContributionRate("2");
        calculatorPage.clickIncludeSocialSecurityBenefits();
        calculatorPage.selectMaritalStatus("married");
        calculatorPage.enterSocialSecurityOverrideAmount("30000");
        calculatorPage.clickDefaultValuesModal();
        calculatorPage.enterAdditionalIncome("500");
        calculatorPage.enterRetirementDuration("20");
        calculatorPage.togglePostRetirementIncome();
        calculatorPage.enterAnnualRetirementIncome("75");
        calculatorPage.enterPreRetirementROI("8");
        calculatorPage.enterPostRetirementROI("5");
        calculatorPage.clickSave();
        calculatorPage.clickSubmit();
    }

}
