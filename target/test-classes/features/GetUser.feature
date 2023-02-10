#language: pt
#Author: erikpatekoski@gmail.com


Funcionalidade: Get Users

@getUser
  Esquema do Cenario: Retorna somente um usuario
    Dado que a chamada foi realizada
    Entao validar o retorno de somente um "<usuario>"
    
    Exemplos:
    |usuario|
    |Janet  |

@getUserList    
  Esquema do Cenario: Retorna lista de usuarios
    Dado que a chamada da listagem foi realizada
    Entao validar quantidade <quantidade> de usuarios por pagina <pagina>
    
    Exemplos:
    |quantidade|pagina|
    |6				 |1			|