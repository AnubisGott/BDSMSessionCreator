package bitsAndBytes.wishes;

public class Wishes {
	
	public static Wish getWish(int index) {
		return WishTypesCreator.getInstance().getWish(index);
	}
	
	public static int getSize() {
		return WishTypesCreator.getInstance().getSize();
	}
}

