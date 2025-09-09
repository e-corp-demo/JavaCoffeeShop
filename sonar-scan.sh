mvn clean verify sonar:sonar \
  -Dsonar.projectKey=e-corp-demo_JavaCoffeeShop_a0509c22-d2a1-4904-83a4-a5ec14211ea3 \
  -Dsonar.projectName='JavaCoffeeShop' \
  -Dsonar.host.url=https://mathiasconradt.ngrok.io \
  -Dsonar.branch.name=product-search
