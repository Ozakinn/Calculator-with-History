import java.io.*;

public class CalcuRW {
	public String prob;
	public String ans;
	
	public int dataPlusprob;
	public int dataPlusans;
	public int dataS;
	public String [] dataprob = new String [dataPlusprob];
	public String [] dataans = new String [dataPlusans];
	
	public boolean t=true;
	
	public void write(String prob,String ans,int data) throws IOException {
		
		File history = new File("HistoryLog.doc");
		history.createNewFile();
		FileWriter historyfw = new FileWriter(history);
		
		dataS= data;
		
		do {
			
		
			dataprob[dataPlusprob]=prob;
			dataans[dataPlusans]=ans;
			
			
			historyfw.write(dataprob[dataPlusprob] + " "+dataans[dataPlusans]+"\n");
			dataPlusprob++;
			dataPlusans++;
			
			}while(dataPlusans != dataS);
			historyfw.close();
		
	}
	
	public int dataSplus() {
		return dataS;
	}
	
}
