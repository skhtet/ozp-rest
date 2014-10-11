package marketplace

enum ApprovalStatus {
    IN_PROGRESS('In Progress'),
    PENDING('Pending'),
    APPROVED('Approved'),
    REJECTED('Rejected')

    private String name

    private ApprovalStatus(String name) {
        this.name = name
    }

    public String toString() { name }

    public static ApprovalStatus findByStatus(String status) throws IllegalArgumentException {
        ApprovalStatus value = values().find { it.name == status }

        if(!value) throw new IllegalArgumentException("'$status' is not a valid approval status")

        value
    }
}
