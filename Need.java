import java.util.HashMap;

public class Need
{
	private int needID;
	private String paintNo;
	private String manu;
	private boolean acrylic;
	private boolean enamel;
	
	public Need(int iD, String num, String man, boolean aGood, boolean eGood)
	{
		needID = iD;
		paintNo = num;
		manu = man;
		acrylic = aGood;
		enamel = eGood;
	}
	
	public Need(String strNeed)
	{
		String[] elements = strNeed.split("|");
		needID = Integer.parseInt(elements[0]);
		paintNo = elements[1];
		manu = elements[2];
		acrylic = Boolean.parseBoolean(elements[3]);
		enamel = Boolean.parseBoolean(elements[4]);
	}
	
	public String toString()
	{
		return needID+"|"+paintNo+"|"+manu+"|"+acrylic+"|"+enamel;
	}
	
	public int getNeedID()
	{
		return needID;
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
		return acrylic;
	}
	
	public boolean getEnamel()
	{
		return enamel;
	}
	
	public boolean isSatisfied(Tin tin, HashMap<String, Equivalence> equivs)
	{
		if(tin.getManu().equals(manu))
		{
			if(tin.getPaintNo().equals(paintNo))
			{
				if(tin.getAcrylic())
				{
					if(acrylic)
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else
				{
					if(enamel)
					{
						return true;
					}
					else
					{
						return false;
					}
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			if(equivs.containsKey(getPaintID()))
			{
				Equivalence equ = equivs.get(getPaintID());
				String[] nums = equ.getEquiv(tin.getManu());
				for(String num : nums)
				{
					if(tin.getPaintNo().equals(num))
					{
						return true;
					}
				}
				return false;
			}
			else
			{
				return false;
			}
		}
	}
}