# Get the current branch name directly using command substitution
CURRENT_BRANCH=$(git branch --show-current)

# Check if the command was successful and a branch name was found
if [ -z "$CURRENT_BRANCH" ]; then
    echo "Error: Could not determine the current Git branch."
    exit 1
fi

mvn clean verify sonar:sonar \
  -Dsonar.projectKey=e-corp-demo_JavaCoffeeShop_a0509c22-d2a1-4904-83a4-a5ec14211ea3 \
  -Dsonar.projectName='JavaCoffeeShop' \
  -Dsonar.host.url=https://mathiasconradt.ngrok.io \
  -Dsonar.branch.name=$CURRENT_BRANCH
