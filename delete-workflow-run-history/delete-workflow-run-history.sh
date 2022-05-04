org=<your org>
repo=<your repo>

# Get workflow IDs with status "disabled_manually"
# workflow_ids=($(gh api repos/$org/$repo/actions/workflows | jq '.workflows[] | select(.["state"] | contains("disabled_manually")) | .id'))
# Get workflow IDs with workflow "name"
workflow_ids=($(gh api repos/$org/$repo/actions/workflows | jq '.workflows[] | select(.["name"] | contains("<input workflow name>")) | .id'))

for workflow_id in "${workflow_ids[@]}"
do
  echo "Listing runs for the workflow ID $workflow_id"
  run_ids=( $(gh api repos/$org/$repo/actions/workflows/$workflow_id/runs --paginate | jq '.workflow_runs[].id') )
  for run_id in "${run_ids[@]}"
  do
    echo "Deleting Run ID $run_id"
    # trim the run_id whitespace
    runid=$(echo $run_id | tr -d '"')
    gh api repos/$org/$repo/actions/runs/$runid -X DELETE >/dev/null
  done
done