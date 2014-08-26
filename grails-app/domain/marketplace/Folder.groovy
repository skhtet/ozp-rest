package marketplace

class Folder implements Serializable, Comparable<Folder> {
    String title

    static belongsTo = Profile
    static hasMany = [serviceItems: ServiceItem]

    //sort ServiceItems by title
    SortedSet<ServiceItem> serviceItems = new TreeSet([
        compare: { a, b -> a.title <=> b.title }
    ] as Comparator)

    static constraints = {
        title(nullable: true)
    }

    public boolean equals(other) {
        other instanceof Folder && other.title == title
    }

    public int hashCode() {
        title?.hashCode() ?: 0
    }

    public int compareTo(Folder other) {
        other ? (title <=> other.title) : 1
    }
}
