#  Camada Enums (PT-BR)

## 🎯 Função principal

**Enums** (Abreviação de enumeração), é um tipo especial de dados usado para **representar um grupo fixo de valores**. Usado quando  se deseja limitar aa opções de uma variável a um conjunto específico de valores.
O Enum é composto por objetos reais.

```java

public enum StatusEnum {  
  ATIVO(1,"Ativo"),
  INATIVO(0,"Inativo");    //ATIVO e INATIVO são objetos/instâncias fixas de StatusEnum, criadas automaticamente na inicialização de enum.

  private integer codigo;
  private string descricao;

  StatusEnum(integer codigo, string descricao) {  //Cada instância de StatusEnum chama o construtor ao ser criada
    this.codigo = codigo;
    this.descricao = descricao;
    }

  public integer getCodigo() { return codigo;}
  public string getDescricao() {return descricao;}

  //retorna o enum correspondente ao código
  public static StatusEnum toEnum(integer cod){
    if (cod=null) {return null}

    for(StatusEnum status: StatusEnum.values()) { // StatusEnum.ATIVO.getCodigo(), StatusEnum.INATIVO.getCodigo(),
      if(cod.equals(status.getCodigo()) {
           return status;
        } 
     }

     throw new IllegalArgumentException("status inválido: " + cod );
}

```



