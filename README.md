# Spring + Hibernate with Kotlin

Alguns plugins maven são necessários ao usar Spring/Hibernate com Kotlin.

Algumas configurações não funcionam sem eles, exemplo: o Lazy em relacionamentos.

A aplicação é bem simples e tem um classe de teste para demonstrar o uso dos plugins. Dê uma olhada no POM.XML e nos seus comentários. Da mesma forma a classe Comment e seus relacionamentos.

Ao configurar seu template inicial via [Spring Initializr](https://start.spring.io/) os seguintes plugins já vem com uma aplicação Kotlin:

``` xml
<compilerPlugins>
    <plugin>spring</plugin>
    <plugin>jpa</plugin>
</compilerPlugins>
```

e

``` xml
<dependencies>
    <dependency>
        <groupId>org.jetbrains.kotlin</groupId>
        <artifactId>kotlin-maven-allopen</artifactId>
        <version>${kotlin.version}</version>
    </dependency>
    <dependency>
        <groupId>org.jetbrains.kotlin</groupId>
        <artifactId>kotlin-maven-noarg</artifactId>
        <version>${kotlin.version}</version>
    </dependency>
</dependencies>
```

O plugins do Spring é descrito aqui: [spring-kotlin](https://kotlinlang.org/docs/reference/compiler-plugins.html#spring-support)

E o plugin do JPA aqui: [kotlin-jpa](https://kotlinlang.org/docs/reference/compiler-plugins.html#jpa-support)

Mas para que o `Lazy` funcione como deveria, é necessária uma config extra:

``` xml
<pluginOptions>
    <!-- Necessário para o lazy funcionar - o plugin 'spring' acima não se estende as anotações abaixo, apenas anotações do spring -->
    <!-- Desative as 3 linhas abaixo e rode o teste 'CommentRepositoryTest' para ver o Lazy sendo ignorado -->
    <option>all-open:annotation=javax.persistence.Entity</option>
    <option>all-open:annotation=javax.persistence.MappedSuperclass</option>
    <option>all-open:annotation=javax.persistence.Embeddable</option>
</pluginOptions>
``` 

Alguns artigos sugerem que não devemos usar `data class` para entidades, pelo fato de não poderem ter hierarquia/subclasse, já outros atribuiem ao fato de que as funções `equals`/`hashCode` são geradas automaticamente ao trabalhar com o Hibernate, especialmente porque o identificador de entidade pode ser definido após o objeto ser construído. Significando que nossas classes "nunca podem" ser imutáveis.

Mas mesmo que não usemos a "comodidade" de uma `data class`, e sim uma `class`, ainda incorremos no mesmo problema.

Artigo completo falando do assunto: https://kotlinexpertise.com/hibernate-with-kotlin-spring-boot/ 

Leia também sobre os plugins:

* [no-arg](https://kotlinlang.org/docs/reference/compiler-plugins.html#no-arg-compiler-plugin)
* [all-open](https://kotlinlang.org/docs/reference/compiler-plugins.html#all-open-compiler-plugin)
