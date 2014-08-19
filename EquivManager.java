import java.util.HashMap;

public class EquivManager
{
	private HashMap<String, Equivalence> equivs = new HashMap<String, Equivalence>();
	private String ln;
	
	public EquivManager()
	{
		ln = System.getProperty("line.separator");
	}
	
	private String stringHashMap()
	{
		String str = "";
		for(Equivalence equ : equivs.values())
		{
			str = str + equ + ln;
		}
		return str.trim();
	}
	
	private void unstringHashMap(String str)
	{
		String[] strArr = str.split(ln);
		for(String equStr : strArr)
		{
			Equivalence equ = new Equivalence(equStr);
			equivs.put(equ.getPaintID(), equ);
		}
	}
	
	public void save()
	{
		String file = stringHashMap();
		FileIO.writeFile("Data/equivalences.txt", file);
	}
	
	public void load()
	{
		String file = FileIO.readFile("Data/equivalences.txt");
		unstringHashMap(file);
	}
	
	public HashMap<String, Equivalence> getEquivs()
	{
		return equivs;
	}
	
	public void addEquiv(String pOne, String pTwo)
	{
		Equivalence equ = equivs.get(pOne);
		equ.addEquiv(pTwo);
		equ = equivs.get(pTwo);
		equ.addEquiv(pOne);
	}
}