package metier;

public class ComboItem {

	private String label;
    private int value;
    private int id;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

    public ComboItem(String label, int value, int id) {
		super();
		this.label = label;
		this.value = value;
		this.id = id;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return label;
    }
}
