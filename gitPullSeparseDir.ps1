Write-Host "Current directory $PSScriptRoot"
$originUrl = Read-Host -Prompt "origin url: "
$dirName = Read-Host -Prompt "Enter the name of the directory to create: " 
$checkOutBranch = Read-Host -Prompt "checkout local branch name: "
$pullBranch = Read-Host -Prompt "pull remote branch name: "
$sparseDir = Read-Host -Prompt "sparse directory name: "


Set-Location $PSScriptRoot
mkdir $dirName
Set-Location $dirName
git init
git remote add origin $originUrl
git checkout -b $checkOutBranch
git config core.sparsecheckout true
$sparseDir + "/" >> .git/info/sparse-checkout
git pull origin $pullBranch


