public class Paint
{
	private String paintNo;
	private String manu;
	private String colour;
	private String finish;
	
	public Paint(String num, String man, String col, String fin)
	{
		paintNo = num;
		manu = man;
		colour = col;
		finish = fin;
	}
	
	public Paint(String strPaint)
	{
		String[] elements = strPaint.split("|");
		paintNo = elements[0];
		manu = elements[1];
		colour = elements[2];
		finish = elements[3];
	}
	
	public String toString()
	{
		return paintNo+"|"+manu+"|"+colour+"|"+finish;
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
	
	public String getColour()
	{
		return colour;
	}
	
	public String getFinish()
	{
		return finish;
	}
	
	public boolean matches(String paintID)
	{
		return paintID.equals(manu+"-"+paintNo);
	}
	
	public boolean matches(String num, String man)
	{
		if(num.equals(paintNo) && man.equals(manu))
			return true;
		return false;
	}
}