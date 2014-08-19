public class Tin
{
	private int tinID;
	private String paintNo;
	private String manu;
	private boolean isAcrylic;
	private String amount;
	
	public Tin(int iD, String num, String man, boolean acrylic, String amnt)
	{
		tinID = iD;
		paintNo = num;
		manu = man;
		isAcrylic = acrylic;
		amount = amnt;
	}
	
	public Tin(String strTin)
	{
		String[] elements = strTin.split("|");
		tinID = Integer.parseInt(elements[0]);
		paintNo = elements[1];
		manu = elements[2];
		isAcrylic = Boolean.parseBoolean(elements[3]);
		amount = elements[4];
	}
	
	public String toString()
	{
		return tinID+"|"+paintNo+"|"+manu+"|"+isAcrylic+"|"+amount;
	}
	
	public int getTinID()
	{
		return tinID;
	}
	
	public String getPaintID()
	{
		return manu+"-"+paintNo;
	}
	
	public String getPaintNo()
	{
		return paintNo;
	}
	
	public String getManu()
	{
		return manu;
	}
	
	public boolean getAcrylic()
	{
		return isAcrylic;
	}
	
	public String getAmount()
	{
		return amount;
	}
}