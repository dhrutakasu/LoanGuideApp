package com.info.aadhaarpeloan.guideinfoapp.LoanConstants;

import android.content.Context;

import com.info.aadhaarpeloan.guideinfoapp.LoanModels.BankLoanModel;
import com.info.aadhaarpeloan.guideinfoapp.LoanModels.DocumentModel;
import com.info.aadhaarpeloan.guideinfoapp.LoanModels.FAQsModel;
import com.info.aadhaarpeloan.guideinfoapp.R;

import java.util.ArrayList;

public class LoanConst {
    public static String AadhaarPos = "AadhaarPos";
    public static String AadhaarDetail = "AadhaarDetail";

    public static ArrayList<FAQsModel> getFAQsDetails() {
        ArrayList<FAQsModel> faQsModels = new ArrayList<>();
        faQsModels.add(new FAQsModel("1. What are the key steps in the loanfinance approval process?", "☞ Approval of loanfinance is at the sole discretion of the loanfinance sanctioning officer who bases his/her\ndecision on the basis of the criteria specified by the bank/ financial institution. The entire\nprocess can take from about 48 hours. Once all the necessary documents are submitted and\nthe verification process is completed, the loanfinance, if sanctioned, is disbursed by the bank. In\norder to avoid delays in loanfinance processing and disbursement, do keep all necessary documents\nready along with the post dated checks (PDC) and/or signed Electronic Clearing System\nform."));
        faQsModels.add(new FAQsModel("2. How to decide which bank/financial institution to take the loanfinance from?", "☞ It is always a good idea to compare the offers of individual banks before you decide to settle\non a specific provider. Use online tools like the loanfinance eligibility calculator and personal loanfinance\nEMI calculator to find the loanfinance option that suits you the best. Some of the key factors to\nconsider when deciding on a loanfinance provider include interest rates, loanfinance tenure, processing fees\nand others."));
        faQsModels.add(new FAQsModel("3. Should I always choose the lowest possible EMI when choosing my loanfinance provider?", "☞ Low EMI offers can typically result from a low interest rate, a long repayment term or a\ncombination of the two factors. Thus in some cases, you might end up paying a lot more to\nyour lender as interest if you choose the lower EMI option. Instead use online tools like the\npersonal loanfinance EMI calculator to figure out your interest payout over the loanfinance tenure and your\nrepayment capacity before making your decision."));
        faQsModels.add(new FAQsModel("4. How do I compare the interest rates of loans?", "☞ Log on to Paisabazaar.com and fill out our personal loanfinance eligibility tool to get a list of all\navailable personal loanfinance option along with key data such as applicable interest rate, processing\nfees as well as information about other charges such as pre-payment charges. Using these\ndata, you can easily compare the various personal loanfinance options available with multiple banks\nand NBFCs."));
        faQsModels.add(new FAQsModel("5. How do I get the lowest interest rates on personal loanfinance?", "☞ Earlier, you might have had to go to multiple lenders in order to get the information regarding\ninterest rates, tenures, processing fees etc. Not anymore. Just log on to Paisabazaar.com and\nfill out the simple form in our loan sections and in seconds you get information\nregarding numerous prospective lenders along with the applicable interest rates and various\ncharges including processing fees. You can easily choose the lowest interest rate from the\navailable list and apply for a personal loanfinance within minutes from the convenience of your\nhome or workplace."));
        faQsModels.add(new FAQsModel("6. Are personal loanfinance interest rates fixed or floating?", "☞ In case of a fixed rate personal loanfinance, your EMI amount remains fixed therefore every month\nduring the loanfinance tenure, you will pay the exact same amount as EMI. In case of a floating rate\npersonal loanfinance, the EMI amount will keep decreasing as it follows the reducing balance\nmethod of calculating interest payout on a personal loanfinance. In case of a floating rate, the\n\napplicable interest rate may be varied by the bank periodically as per the new MCLR rules,\nfloating interest rates may be changed either on a half yearly or yearly basis."));
        faQsModels.add(new FAQsModel("7. What is relationship discount?", "☞ Relationship discount is an additional benefit that is provided by the banks or lenders to a\nprospective applicant if they have a pre-existing relationship with the lender. Such pre-\nexisting relationship may include having a salary/savings account with the bank or having an\nexisting credit card, fixed deposit or loanfinance with the prospective lender.  Relationship discounts\nmay result in the lender providing you with discounts when applying for the loanfinance like –\nwaiver of the processing fees, lower interest rates or others."));
        faQsModels.add(new FAQsModel("8. How is the personal loanfinance disbursed?", "☞ Once you get approved for a personal loanfinance, you may either receive an account payee\ncheque/draft equal to the loanfinance amount or get the money deposited automatically into your\nsavings account electronically."));
        faQsModels.add(new FAQsModel("9. Which are the best banks and NBFCs for a personal loanfinance?", "☞ loans are offered by all leading banks and numerous NBFCs (non-banking financial\ncompanies). Some of the leading providers of loans include HDFC Bank, IndusInd\nBank, Citibank, Axis Bank, Fullerton India, Capital First, State Bank of India and Associates,\nIndian Bank, Karnataka Bank, Standard Chartered Bank and many others."));
        faQsModels.add(new FAQsModel("10. How to repay the personal loanfinance?", "☞ The loanfinance can be repaid in the form of Equated Monthly Installment (EMI) via post-dated\ncheques   drawn in favour of the bank or by releasing a mandate allowing payment through\nthe Electronic Clearing Services (ECS) system."));
        faQsModels.add(new FAQsModel("11. What is the minimum credit score to get a personal loanfinance?", "☞ It depends on the eligibility criteria set by the lender. Most lenders do not specify a\nminimum credit score for a personal loanfinance. Some lenders might lend to applicants with low\ncredit score (less than 750) but the interest rate applicable is usually higher in such cases."));
        faQsModels.add(new FAQsModel("12. What is the minimum salary required to get a personal loanfinance?", "☞ The minimum monthly salary required to avail personal loanfinance varies from lender to\nlender. However, for large lenders like private and public sector banks, the minimum income\neligibility is Rs. 15,000 per month and above."));
        faQsModels.add(new FAQsModel("13. Can I get a personal loanfinance being a pensioner, if I have a pension account with one of the\nleading banks in India?", "☞ Yes, you can get a personal loanfinance even as a pensioner, if you have a pension account\nwith one of the leading banks. However, you should ensure that the bank where you receive\npension funds offers loans to pensioners and you meet the eligibility criteria as\nspecified by your prospective lender."));
        faQsModels.add(new FAQsModel("14. How to choose the ideal repayment tenor for business loans?", "☞ Ideally, if you avail short-term loanfinance then the repayment tenure should not exceed 12\nmonths. However, it may increase as per the desired loanfinance amount. The maximum repayment\nperiod can be chosen up to 5 years depending upon the loanfinance amount."));
        faQsModels.add(new FAQsModel("15. What is the minimum turnover requirement for a loanfinance to start a business?", "☞ The minimum annual turnover criteria is defined by the lender and vary from bank to\nbank. However, applicants shall apply online with a minimum annual turnover of Rs. 12 lakh\nor above for existing enterprises or businesses."));
        faQsModels.add(new FAQsModel("16. What are the pre-closure and part-prepayment charges in business loans?", "☞ The pre-closure and part-payment charges vary from lender to lender. It may be Nil\nfrom some banks and may exceed up to 5% of the loanfinance amount from others. Ensure to check\nthe same with your lender."));
        faQsModels.add(new FAQsModel("17. Which bank is the best for home loanfinance?", "☞ Some of the most popular banks offering home loans in india are HDFC Bank, SBI, PNB, ICIC Bank, Bank of Baroda,\nAxis Bank and Canara Bank. However, the best home loanfinance for you would be the one that matches your loanfinance requirements.\nTherefore, to get the best bank for a home loanfinance first analysis your requirements. Also, when comparing home loanfinance offers don't\njump for the offer that offers the lowest interest rate,rather check on the entire deal, Besides the interest rate, pay\nattenation to other parameters such as processing fees and the loanfinance repayment and prepayment policies."));
        faQsModels.add(new FAQsModel("18. Are there any prepayment charges in case of a home loanfinance?", "☞ In the case of a floating rate home loanfinance, lenders don't change a pre-payment\npenalty as per RBI directives however a penalty may be applied in case of prepayment\nof a fixed-rate home loanfinance."));
        faQsModels.add(new FAQsModel("19. What types of properties are accepted by lenders providing Loan Against Property\n(LAP)?", "☞ Different lenders have different criteria for the type of property to be accepted against a\nmortgage loanfinance. However,mostly all financial institutions accept the residential, commercial\nor industrial property. It is important to note that the physical condition and age of the\nproperty may affect its acceptance by the financial institution."));
        faQsModels.add(new FAQsModel("20. Can NRIs avail loans against the property?", "☞ Yes, there are several financial institutions that offer loanfinance against property to NRIs."));
        return faQsModels;
    }

    public static ArrayList<String> getRequiredDocument(Context context) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add(context.getString(R.string.home_loan));
        stringArrayList.add(context.getString(R.string.bussiness_loan));
        stringArrayList.add(context.getString(R.string.mortigage_loan));
        stringArrayList.add(context.getString(R.string.balance_transfer_home_loan));
        stringArrayList.add(context.getString(R.string.balance_transfer_mortigage_loan));
        return stringArrayList;
    }

    public static ArrayList<String> getLoanAadhaar() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("What is Aadhaar Loan ?");
        stringArrayList.add("Impact of Aadhaar on Loan");
        stringArrayList.add("Apply for Loan Online");
        stringArrayList.add("Top Bank List");
        stringArrayList.add("Document List");
        stringArrayList.add("Transfer Loan");
        stringArrayList.add("Eligibility");
        return stringArrayList;
    }

    public static ArrayList<String> getLoanDocumentList() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("For Salaried Employees");
        stringArrayList.add("For Self-Employed Individuals");
        stringArrayList.add("For NRI Applicants");
        stringArrayList.add("For Pensioners");
        return stringArrayList;
    }

    public static DocumentModel getLoanDocumentModel(int pos) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        DocumentModel documentModel = new DocumentModel();
        switch (pos) {
            case 0: {
                stringArrayList.add("Signed application form along with a photograph");
                stringArrayList.add("Identity proof such as Aadhaar card, PAN card, Voter Id card, or passport");
                stringArrayList.add("Address proof such as passport, utility bills like electricity, gas, water, or telephone, and driving license");
                stringArrayList.add("Age proof such as school and college leaving certificates, birth certificates, and voter Id card");
                stringArrayList.add("Income proof such as ITR forms, form 16, last six months salary slips, and banking statements");
                documentModel = new DocumentModel("Salaried individuals can avail aadhaar loans by submitting the following aadhaar loanfinance documents:", stringArrayList);
            }
            break;
            case 1: {
                stringArrayList.add("Signed application form along with a photograph");
                stringArrayList.add("Identity proof such as Aadhaar card, PAN card, Voter Id card, or passport");
                stringArrayList.add("Age proof such as school and college leaving certificates, birth certificates, and voter Id card");
                stringArrayList.add("Address proof such as passport, utility bills like electricity, gas, water, or telephone, and driving license");
                stringArrayList.add("Income proof such as ITR forms, form 16, 6 months salary slips, and bank statements");
                stringArrayList.add("Proof of their business existence through documents like the partnership deed, certificate of practice, registration certificate, and PAN card of the business enterprise.");
                documentModel = new DocumentModel("Self-employed individuals can avail a aadhaar loanfinance by submitting the following aadhaar loanfinance documents:", stringArrayList);
            }
            break;
            case 2: {
                stringArrayList.add("Signed application form along with a photograph");
                stringArrayList.add("Identity proof such as Aadhaar card,PAN card, Voter Id card, or Passport");
                stringArrayList.add("Address proof such as passport, utility bills like electricity, gas, water, or telephone, and driving license");
                stringArrayList.add("Age proof such as school and college leaving certificates, birth certificates, and voter Id card");
                stringArrayList.add("Income proof such as ITR forms, form 16, last six months salary slips, and banking statements for the last twelve months for both the Indian and international bank accounts");
                stringArrayList.add("Passport and Visa copy");
                stringArrayList.add("The NRI applicant also needs to submit a power of attorney that is attested by the local authorities, in case they are present in the country while availing the loanfinance.");
                stringArrayList.add("All the documents related to salary must be submitted in English.");
                documentModel = new DocumentModel("Even NRIs (Non-Resident Indians) can opt for a aadhaar loanfinance in India by fulfilling the requirements of the following documents:", stringArrayList);
            }
            break;
            case 3: {
                stringArrayList.add("Signed application form along with a photograph");
                stringArrayList.add("Identity proof such as Aadhaar card, PAN card, Voter Id card, or Passport");
                stringArrayList.add("Address proof such as passport, utility bills like electricity, gas, water, or telephone, and driving license which should not be older than last three months");
                stringArrayList.add("Age proof such as school and college leaving certificates, birth certificates, and voter Id card");
                stringArrayList.add("Income proof such as ITR forms or form 16 from the last two years, last six months salary slips, and banking statements");
                documentModel = new DocumentModel("A retired individual person can also avail aadhaar loans as per the submission of the following aadhaar loanfinance documents:", stringArrayList);
            }
            break;
        }
        return documentModel;
    }

    public static BankLoanModel getLoanBankModel(int pos) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<String> SubStringArrayList = new ArrayList<>();
        BankLoanModel bankLoanModel = new BankLoanModel();
        switch (pos) {
            case 0: {
                stringArrayList.add("HDFC Bank aadhaar Loan interest rate starts from 10.49%.");
                stringArrayList.add("The processing fee charged on HDFC aadhaar loanfinance is Upto 2.50% Min ₹ 999");
                stringArrayList.add("If you have a good credit score and  history, you can get HDFC pre-approved aadhaar loanfinance");
                stringArrayList.add("You can avail HDFC aadhaar loanfinance online by applying and submitting documents digitally");
                stringArrayList.add("You can easily check your HDFC aadhaar loanfinance application status on a real-time basis on the bank’s website or by visiting their customer care centre");
                stringArrayList.add("HDFC Bank has special schemes for different income and occupation groups.");
                SubStringArrayList.add("Proof of identity: Aadhaar Card, Driving License, Passport, etc.");
                SubStringArrayList.add("Proof of address: Voter ID Card, Aadhaar Card, Passport, or Driving License");
                SubStringArrayList.add("Other documents: Bank statements for last 3 months, form 16, latest salary slip, passport size photographs");
                bankLoanModel = new BankLoanModel("HDFC Aadhaar Loan", "The bank offers aadhaar loanfinance starting at an interest rate of 11.00%. HDFC offers multiple tenure options, quick processing and great customer service. Applicants are not required to pledge collateral or security to avail the loanfinance.", stringArrayList, SubStringArrayList);
            }
            break;
            case 1: {
                stringArrayList.add("The Interest Rate on ICICI Bank aadhaar loans ranges from 10.50% - 22.00%.");
                stringArrayList.add("ICICI Bank also offers pre-approved aadhaar loans at low rates for customers with strong credit history and those with an existing account with the bank.");
                stringArrayList.add("ICICI Bank has special schemes for different income and occupation groups.");
                SubStringArrayList.add("Proof of identity: Aadhaar Card, Driving License, Passport, etc");
                SubStringArrayList.add("Proof of address: Voter ID Card, Aadhaar Card, Passport, or Driving License");
                SubStringArrayList.add("Salary Slips for the last 3 months");
                SubStringArrayList.add("Bank statements for the last 3 months");
                bankLoanModel = new BankLoanModel("ICICI Aadhaar Loan", "ICICI Bank is one of the leading banks in the private sector. It provides hassle free application process, flexible repayment tenure and minimal documentation.", stringArrayList, SubStringArrayList);
            }
            break;
            case 2: {
                stringArrayList.add("The Interest Rate on SBI aadhaar loans ranges from 10.00% - 13.00%.");
                stringArrayList.add("SBI also offers pre-approved aadhaar loans  at low rates for customers with strong credit history and existing accounts with the bank.");
                stringArrayList.add("The processing fee charged on SBI aadhaar loanfinance is Nil.");
                stringArrayList.add("The bank has an online application process where you can submit the KYC and other documents digitally.");
                stringArrayList.add("You can easily check your on a real-time basis on the bank’s website or by visiting their customer care centre.");
                stringArrayList.add("SBI has special schemes for different income and occupation groups.");
                SubStringArrayList.add("Proof of identity: PAN Card, Aadhaar Card, Driving License, Passport, etc.");
                SubStringArrayList.add("Proof of address: Voter ID Card, Aadhaar Card, Passport, or Driving License");
                SubStringArrayList.add("Income proof: Bank statements for last 3 months, form 16, latest salary slips, last 6 months account statement audited, ITR return for last 2 yrs.");
                SubStringArrayList.add("Other: Passport size photographs");
                bankLoanModel = new BankLoanModel("SBI Aadhaar Loan", "SBI offers aadhaar loans at attractive interest rates. Repayment tenure can go up to 5 years with nominal one time processing fee", stringArrayList, SubStringArrayList);
            }
            break;
            case 3: {
                stringArrayList.add("The Interest Rate on PNB aadhaar loans ranges from 8.80% - 13.30%.");
                stringArrayList.add("PNB  also offers pre-approved aadhaar loans at low rates for customers with strong credit history and those with an existing account with the bank.");
                stringArrayList.add("The bank has an online application process where the KYC and documents submission can be done digitally.");
                stringArrayList.add("You can easily check the status of your  PNB aadhaar loanfinance application status on a real time basis on the bank’s website or by visiting their customer care centre.");
                stringArrayList.add("PNB has special schemes for different income and occupation groups");
                SubStringArrayList.add("Proof of address: Voter ID Card, Aadhaar Card, Passport, PAN Card or Driving License.");
                SubStringArrayList.add("Proof of identity: Aadhaar Card, Driving License, Passport, etc.");
                SubStringArrayList.add("Other documents: Bank statements for last 3 months, form 16, latest salary slips, last 6 months account statement audited, ITR return for last 2 yrs.");
                bankLoanModel = new BankLoanModel("PNB Aadhaar Loan", "PNB offers aadhaar loans at lucrative interest rates and attractive repayment tenures.", stringArrayList, SubStringArrayList);
            }
            break;
        }
        return bankLoanModel;
    }
}
