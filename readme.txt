Para executar a aplicação é necessário subir uma base mongo para que possamos acessa-la.

Dentro da pasta CI, execute os comandos no terminal:
    - docker search mongodb
    - docker-compose up --build -d mongodb

Se preferir apenas executar no terminal desconsidere o último comando e execute:
    - docker-compose up

Após feito o comando a execução da aplicação poderá ser realizada.

Obs: Caso não possua docker ou docker-compose na máquina realize o procedimento do link para realizar a instação de ambos
    Linux:
        - https://www.bmc.com/blogs/mongodb-docker-container/#:~:text=Go%20to%20the%20%E2%80%9Cmongodb%E2%80%9D%20folder,container%20as%20a%20background%20process.&text=The%20up%20command%20will%20pull,yml%20file.
    Windows:
        - https://docs.docker.com/docker-for-windows/install/