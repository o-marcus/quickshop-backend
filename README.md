##  QuicksShop Backend Repository
Bem vindo ao repositório do Quickshop, uma pequena aplicação desenvolvida com Spring Boot + Java para aplicar 
conceitos e padrões importantes na criação de microsserviços.

Ao longo dos commits, estarei fazendo comentários detalhados sobre as alterações realizadas no projeto aqui no README.
Vou explicar por que cada alteração é importante para o desenvolvimento e aprimoramento do QuickShop.
Estou à disposição para discussões e esclarecimentos sobre alterações específicas durante o processo de desenvolvimento e revisão.

###  [ Commits: 'First Commit' e 'add docker-compose file' ]
Comecei o projeto organizando a aplicação em três módulos distintos, cada um representando um microsserviço a ser implementado. O primeiro é o **OrderService**, encarregado de lidar com a realização de pedidos. Em seguida, temos o **InventoryService**, responsável por verificar a disponibilidade de produtos no estoque. Por fim, o terceiro módulo é o **ProductService**, que atuará como um catálogo para consultar informações sobre todos os produtos na aplicação.

Além disso, criei o arquivo **docker-compose** para executar os containeres com as instâncias do MySQL e MongoDB que estão sendo utilizadas. Isso demonstra a versatilidade do emprego de microsserviços, uma vez que, além de possuírem bases de dados distintas, operam com sua própria instância de dados.

