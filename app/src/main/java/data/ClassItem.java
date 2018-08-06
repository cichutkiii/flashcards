package data;

public class ClassItem {
    public ClassItem() {
    }

    public String language;
    public String classes;
    public String name;
    public String ondata;
    public String descr;

    public ClassItem(String language, String classes, String name, String onDatabase, String descr) {
        this.language = language;
        this.classes = classes;
        this.name = name;
        this.ondata = onDatabase;
        this.descr = descr;
    }

    public String getLanguage() {

        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOnDatabase() {
        return ondata;
    }

    public void setOnDatabase(String onlink) {
        this.ondata = onlink;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
