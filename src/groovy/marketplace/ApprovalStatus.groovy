package marketplace

enum ApprovalStatus {
    IN_PROGRESS('In Progress'),
    PENDING('Pending'),
    APPROVED_ORG('Approved by Organization'),
    APPROVED('Approved'),
    REJECTED('Rejected')

    private String name

    private ApprovalStatus(String name) {
        this.name = name
    }
}
