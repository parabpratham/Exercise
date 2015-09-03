package DTBReleaseClasses;

import java.io.File;
import java.text.DecimalFormat;


public class VoulumeCharges {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	
	public static	 void hasSpecialCharacter()
		{
			String specialCharacterArray = "!,@,#,$,%,^,&,*,(,)";
			String[] speciStringsList = specialCharacterArray.split(",");
			
			System.out.print(" if(");
			for(String string:speciStringsList)
			{
				System.out.print("stringBuilderString.contains(\""+string+"\") || ");
			}	
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//hasSpecialCharacter();
		
		
		
//		
//		
//		Double aplicableChargeAmount = 0d;
//		Double adjustedChargeAmount = 0d;
//		Double count = 211d;
//		int counter = 211;
//		
//		Double minimumCharge = 0d;
//		Double maximumCharge = 500000000000d;
//		Double fixedCharge = 150d;
//		Double valuePerUnit = 0d;
//		
//		Double chargeAsPerSetup = ( ( (count / 1000) * valuePerUnit ) + fixedCharge);
//		if(chargeAsPerSetup <= minimumCharge)
//			chargeAsPerSetup = minimumCharge;
//		if(chargeAsPerSetup >= maximumCharge)
//			chargeAsPerSetup = maximumCharge;
//		
//		System.out.println("ChargeAsPerSetup = " + chargeAsPerSetup); 
//		double totalcharge = 0d;
//		DecimalFormat decimalFormat = new DecimalFormat("#.##");
//		decimalFormat.setMaximumFractionDigits(4);
//		
//
//		for(int i=0;i<counter;i++)	{
//			aplicableChargeAmount = ( ( (count / 1000) * valuePerUnit ) + fixedCharge)/count;
//			
//			adjustedChargeAmount = aplicableChargeAmount;
//			
//			if(aplicableChargeAmount*count <= minimumCharge)
//				adjustedChargeAmount = minimumCharge / count;
//			if(aplicableChargeAmount*count >= maximumCharge)
//				adjustedChargeAmount = maximumCharge / count;
//			System.out.println(decimalFormat.format(adjustedChargeAmount.doubleValue()));
//			totalcharge +=  Double.valueOf(decimalFormat.format(adjustedChargeAmount.doubleValue()));
//		}
//		//System.out.println("ChargeCalculated = " + Double.valueOf(decimalFormat.format(totalcharge.doubleValue())));
//		decimalFormat.setMaximumFractionDigits(2);
//		System.out.println("ChargeCalculated = " + Double.valueOf(decimalFormat.format(totalcharge)));
		
		
		
		//String[] strings = {"ActivityEnrichmentHelper.class","ChargeableActivityBO.hbm.xml","ChargeableActivityProcessor.class","EODChargeCalculation.class","EODExceptionBO.class","EODExceptionBO.hbm.xml","EODExceptionService.class","EODExceptionServiceImpl.class","hibernate.cfg.xml","PaymentBatchActivity.class","PrintingActivity.class","ReconcilePrintingServiceImpl.class","ReturnActivity.class","RMIPayProServiceFactory.class"};
//		String[] strings  = {"ActivityEnrichmentHelper","ChargeableActivityBO.hbm.xml","ChargeableActivityProcessor","EODChargeCalculation","EODExceptionBO","EODExceptionBO.hbm.xml","EODExceptionService","EODExceptionServiceImpl","hibernate.cfg.xml","PaymentBatchActivity","PrintingActivity","ReconcilePrintingServiceImpl","ReturnActivity","RMIPayProServiceFactory"};
//		for(String string : strings)
//		{
//			//System.out.println("Copy "+string+" in paypro-distribution.jar at following location in that Jar ");
//			System.out.println(string);
//		}

		
		
		String filePath = "\\\\";
		
		File directory = new File(filePath);
		System.out.println(directory.isDirectory());
		visitAllDirs(directory);
		
	}
	

	// Process only directories under dir
	public static void visitAllDirs(File dir) {
		if (dir.isDirectory()) {

			// You can do whatever you want with this directory
			// E.g. printing its name to the console
			// System.out.println("\nDirectory name# "+dir);
			process(dir);

			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				visitAllDirs(new File(dir, children[i]));

				// break here if you want to stop after iterating in the first
				// directory (for testing)
				// break;
			}

		}
	}
	
	public static void process(File dir) {
		String listFilenames = "";
		String[] strings = {"ActivityEnrichmentHelper.class","ChargeableActivityBO.hbm.xml","ChargeableActivityProcessor.class","EODChargeCalculation.class","EODExceptionBO.class","EODExceptionBO.hbm.xml","EODExceptionService.class","EODExceptionServiceImpl.class","hibernate.cfg.xml","PaymentBatchActivity.class","PrintingActivity.class","ReconcilePrintingServiceImpl.class","ReturnActivity.class","RMIPayProServiceFactory.class"};
		try { // read one text file
			String filename[] = dir.list();
			for (int i = 0; i < filename.length; i++) {
				listFilenames = filename[i];
				System.out.println(listFilenames);
				for(String string: strings)
				{
					if(string.contains("class"))
						string = string.replace("class", "java");
					if(listFilenames.equalsIgnoreCase(string))
					{
						if(string.endsWith("java"))
						{
							string = string.replace("java","class");
						}
						//System.out.println("Copy "+string+" in paypro-distribution.jar at following location in that Jar "+dir.getPath());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
