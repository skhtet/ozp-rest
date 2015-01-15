package marketplace

import javax.servlet.http.HttpServletRequest

/**
 * Holder for audit information about the current request
 */
class ClientAuditData {
    String localAddr
    String remoteAddr

    public static ClientAuditData fromHttpRequest(HttpServletRequest request) {
        new ClientAuditData(
            localAddr: request.localAddr,
            remoteAddr: request.getHeader("x-forwarded-for") ?:
                request.getHeader("X_FORWARDED_FOR") ?:
                request.remoteAddr
        )
    }
}
