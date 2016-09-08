package seedu.addressbook.data.tag;

public class Tagging {
	
	private static StringBuilder fullTaggingList = new StringBuilder (); 
	
	
//	private Person person; 
//	private Tag tag; 
//	private boolean isAdded; 
//	
//	public Tagging (Person person, Tag tag, boolean isAdded){
//		this.person = person; 
//		this.tag = tag; 
//		this.isAdded = isAdded;
//	}
	
	public static void addAllTagsToTheEndMassage(String name, UniqueTagList tags) {
		for (Tag tag : tags) { 
			Tagging.modifyTaggingList (name, tag.toString() ,true);
        }
	}
	
	public static void modifyTaggingList (String name, String tag, boolean isAdded){ 
		if (isAdded){ 
			fullTaggingList.append("+ ");
		}
		else { 
			fullTaggingList.append("- ");
		}
		fullTaggingList.append(name + " " + tag + " \n");
	}

	public static String getFullTaggingList () { 
		return fullTaggingList.toString(); 
	}
}
