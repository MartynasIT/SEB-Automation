# **Project Setup**
This project requires Java 11 to be installed on your system. This is because the Jenkins server used in this project requires Java 11.

- First, switch to the "servers" branch. Then, copy all the files from this branch to a directory of your choice.

- To start the Jenkins server, run the start_jenkins_server.bat file.

- To start the Grid server, run the start_grid_server.bat file.

- Once the servers are running, you can access the Jenkins dashboard by visiting http://localhost:8080 in your web browser.
- After logging in, you can use the "Automation" job to run API tests (includes performance test for amazon and checks if amazon, grid and jenkins servers are reachable) and WEB tests (Fidget spinners test).

It's important to note that these instructions are for Windows.
