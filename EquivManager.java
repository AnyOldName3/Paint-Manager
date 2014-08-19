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
		Equivalence equ;
		if(equivs.containsKey(pOne))
		{
			equ = equivs.get(pOne);
			equ.addEquiv(pTwo);
		}
		else
		{
			equ = new Equivalence(pOne, pTwo);
			equivs.put(pOne, equ);
		}
		if(equivs.containsKey(pTwo))
		{
			equ = equivs.get(pTwo);
			equ.addEquiv(pOne);
		}
		else
		{
			equ = new Equivalence(pTwo, pOne);
			equivs.put(pTwo, equ);
		}
	}
	
	public void addEquiv(String manOne, String numOne, String manTwo, String numTwo)
	{
		Equivalence equ;
		if(equivs.containsKey(manOne+"-"+numOne))
		{
			equ = equivs.get(manOne+"-"+numOne);
			equ.addEquiv(manTwo, numTwo);
		}
		else
		{
			equ = new Equivalence(numOne, manOne, manTwo, numTwo);
			equivs.put(manOne+"-"+numOne, equ);
		}
		if(equivs.containsKey(manTwo+"-"+numTwo))
		{
			equ = equivs.get(manTwo+"-"+numTwo);
			equ.addEquiv(manOne, numOne);
		}
		else
		{
			equ = new Equivalence(numTwo, manTwo, manOne, numOne);
			equivs.put(manTwo+"-"+numTwo, equ);
		}
	}
}