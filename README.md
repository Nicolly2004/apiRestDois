apiRest2: é um back-end com CRUD, para cadastrar, listar, atualizar e deletar

Inicie a aplicação abrindo o projeto no Intellij e o abrindo o docker, depois do docker startado, a aplicação funcionará quando as rotas forem postas corretamente, seguido o protocolo http
Para Cadastrar: http://127.0.0.1:8080/usuarios
Para Listar: http://127.0.0.1:8080/usuarios
Para Deletar: http://127.0.0.1:8080/usuarios/{id}
Para atualizar: http://127.0.0.1:8080/usuarios/{id} -> a atualização dos dados deve ser feita no formato JSON e com todas as informações do usuário;
Caso queira atualizar somente o e-mail, por exemplo, coloque todas as informações como, nome, e-mail, login e senha, atualize o que for necessário e rode a aplicação

As dependências baixadas para que o programa rode, são: Spring web, mysql Driver e spring boot JPA
