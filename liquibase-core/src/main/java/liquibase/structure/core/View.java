package liquibase.structure.core;

public class View extends Relation {

    public View() {
    }

    public View(String catalogName, String schemaName, String tableName) {
        this.setSchema(new Schema(catalogName, schemaName));
        setName(tableName);
    }

    @Override
    public Relation setSchema(Schema schema) {
        return super.setSchema(schema);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public String getDefinition() {
        return getAttribute("definition", String.class);
    }

    public void setDefinition(String definition) {
        this.setAttribute("definition", definition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        View that = (View) o;

        return getName().equalsIgnoreCase(that.getName());

    }

    @Override
    public int hashCode() {
        return getName().toUpperCase().hashCode();
    }

    @Override
    public String toString() {
        String viewStr = getName() + " (";
        for (int i = 0; i < getColumns().size(); i++) {
            if (i > 0) {
                viewStr += "," + getColumns().get(i);
            } else {
                viewStr += getColumns().get(i);
            }
        }
        viewStr += ")";
        return viewStr;
    }

    @Override
    public View setName(String name) {
        return (View) super.setName(name);
    }


}
