import java.util.ArrayList;
import java.util.Arrays;

public class Equivalence
{
	private String paintNo;
	private String manu;
	
	private ArrayList<String> manus = new ArrayList<String>();
	private ArrayList<String> numbers = new ArrayList<String>();
	
	public Equivalence(String num, String man, String[] mans, String[] nums)
	{
		paintNo = num;
		manu = man;
		manus = new ArrayList<String>(Arrays.asList(mans));
		numbers = new ArrayList<String>(Arrays.asList(nums));
	}
	
	public Equivalence(String str)
	{
		this(str.split("|")[0], str.split("|")[1], str.split("|")[2].split(","), str.split("|")[3].split(","));
	}
	
	public String toString()
	{
		String str = paintNo+"|"+manu+"|";
		for(String man : manus)
		{
			str = str + man + ",";
		}
		str = str.substring(0, str.length()-1);
		for(String num : numbers)
		{
			str = str + num + ",";
		}
		str = str.substring(0, str.length()-1);
		return str;
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
	
	public void addEquiv(String man, String num)
	{
		man = new String(man);
		manus.add(man);
		int i = manus.indexOf(man);
		numbers.add(i, num);
	}
	
	public void addEquiv(String pntID)
	{
		String[] manNum = pntID.split("-");
		addEquiv(manNum[0], manNum[1]);
	}
	
	public String[] getEquiv(String man)
	{
		ArrayList<String> matches = new ArrayList<String>();
		for(String aMan : manus)
		{
			if(man.equals(aMan))
			{
				int i = manus.indexOf(aMan);
				matches.add(numbers.get(i));
			}
		}
		return matches.toArray(new String[0]);
	}
}