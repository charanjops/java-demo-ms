# java-demo-ms
This is the demo app for the devops practice

DevSecOps Security Principles
🔐 1. Shift-Left Security

Security runs before deployment, not after incidents.

✔ SAST
✔ Dependency scanning
✔ Image vulnerability scanning

🔐 2. SAST – Static Application Security Testing

Tool: Semgrep

Detects:

Hardcoded secrets

Injection flaws

Insecure APIs

OWASP Top 10 issues

🚫 Merge blocked if violations exist

🔐 3. Software Supply Chain Security (SCA)

Tool: OWASP Dependency Check

Scans Maven dependencies

Blocks high-risk CVEs (CVSS ≥ 7)

Prevents Log4Shell-type incidents

🔐 4. Container Security

Tool: Trivy

OS + app dependency scanning

Fails pipeline on HIGH / CRITICAL CVEs

Prevents vulnerable images reaching prod

🔐 5. Secrets Security

All secrets stored in GitHub Secrets

No plaintext credentials

CI has no Kubernetes access

🔐 6. GitOps Security Model (Argo CD)

CI never deploys to cluster

CI only commits to Git

Argo CD:

Pulls state

Applies manifests

Provides rollback & audit trail

✔ Immutable deployments
✔ Complete traceability
✔ Zero human kubectl access

🔐 7. Least Privilege & Zero Trust

GitHub token → GitOps repo only

Argo CD → namespace-scoped RBAC

No cluster-admin rights
 