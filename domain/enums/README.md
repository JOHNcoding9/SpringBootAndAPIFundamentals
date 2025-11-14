#  Camada Enums (PT-BR)

## 🎯 Função principal

**Enums** (Abreviação de enumeração), é um tipo especial de dados usado para **representar um grupo fixo de valores**. Usado quando  se deseja limitar aa opções de uma variável a um conjunto específico de valores.
O Enum é composto por objetos reais, são carregados na memória no início da aplicação e seus valores devem ser imutáveis.

```java

public enum StatusEnum {

    ATIVO(1, "Ativo"),
    INATIVO(0, "Inativo");

    private final Integer codigo;
    private final String descricao;

    StatusEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    // Retorna o enum correspondente ao código
    public static StatusEnum toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (StatusEnum status : StatusEnum.values()) {
            if (cod.equals(status.getCodigo())) {
                return status;
            }
        }

        throw new IllegalArgumentException("Status inválido: " + cod);
    }

    // Retorna a descrição diretamente pelo código
    public static String getDescricaoPorCodigo(Integer cod) {
        StatusEnum status = toEnum(cod);
        return (status != null) ? status.getDescricao() : "Código inválido";
    }
}


```


## Enums são ideais para:

🟤 status
🟤 papéis de usuário
🟤 modos de pagamento
🟤 flags fixas


