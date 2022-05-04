$org = '<your-org>';
$repo = '<your-repo>';

# get all workflows
$res = gh api "repos/$org/$repo/actions/workflows" | ConvertFrom-Json

foreach ($workflow in $res.workflows) {
    # if ($workflow.state -eq "disabled_manually") {
    # if ($workflow.state -eq "active") {
    if ($workflow.name -eq "Call a reusable workflow") {
        $runs = gh api "repos/$org/$repo/actions/workflows/$($workflow.id)/runs" | ConvertFrom-Json

        foreach ($run in $runs.workflow_runs) {
            Write-Output "Deleting Run ID: $($run.id)"
            gh api "repos/$org/$repo/actions/runs/$($run.id)" -X DELETE 
        }
    }
}



