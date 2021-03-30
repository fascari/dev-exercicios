# dev-softplan
> Desafio técnico - Softplan

### Exercício 1

Com relação ao legado, optei por refatorar, mantendo o mesmo comportamento, 
mas deixando o código mais enxuto e elegante, preferi trabalhar com streams ao invés do tradicional iterator, também utilizei métodos da própria classe String, para realizar os joins das listas, gerando o resultado esperado com menos linhas de código.

Tenho ciência que em várias situações, utilizar estruturas como lambdas, por exemplo, torna o código menos semântico e adiciona certa complexidade ao entendimento, mas neste caso acredito ter deixado o método mais objetivo.

Removi o atributo de classe, que julguei desnecessário já que por questões de performance prefiro trabalhar com variáveis locais, além disso, renomeei as variáveis e constantes, seguindo um padrão que deixa o código mais compreensível, como prega o clean code.
Transformei a classe de concreta para abstrata e trabalhei com métodos estáticos, esta prática evita a criação desenfreada de objetos pela aplicação, e prioriza a otimização de memória, para este cenário a estrutura se aplica bem, por ser um exercício pequeno que prioriza objetividade, além de deixar os cenários mais performáticos, tenho em mente que métodos estáticos precisam ser utilizados com cuidado dentro das aplicações. Neste caso, caberia até mesmo, a implementação do pattern singleton, o que garantiria apenas uma instância da classe na aplicação, seria uma melhoria futura a ser aplicada.

Trabalhei com a técnica de evitar ao máximo if/elses encadeados, esta abordagem adiciona muita complexidade e dificulta o entendimento de outros devs na manutenção do código, retornos rápidos deixam o código mais limpo e objetivo.
Sempre procuro trabalhar com constantes para Strings, facilitando o entendimento, reutilização e rastreabilidade do código.

No segundo cenário solicitado, optei por trabalhar com o iterator, minha análise foi que trabalhar com stream, poderia deixar o código mais verboso e difícil de compreender, uma vez que, utilizei um map para enviar os valores de identificação da fatura e seu respectivo valor.
Com um stringBuilder e um iterator tive um bom resultado e evitei processos desnecessários que precisariam ser aplicados para trabalhar com stream e map.
Caso não houvesse necessidade da inclusão da preposição “e” ao final da lista, seria muito mais simples trabalhar com stream e o código ficaria muito enxuto, mas dado o requisito apresentado, ficou mais simples, em minha opinião, trabalhar desta forma.

### Exercício 2

Para o segundo exercício, fiz a leitura do json disponibilizado com auxílio da lib do jackson, a qual utilizo bastante no dia – a - dia e acredito que atenda bem as necessidades.
Agrupei as composições por identificador em um map utilizando stream e um collector do próprio java 8, deixando o código limpo e objetivo.

Como o cenário apresentava necessidade de cálculos de sub composições, filtrei as situações em que haviam sub composições e utilizei a estratégia de recursividade para calcular os valores dos itens.

Depois de resolver os subitens, efetuei o cálculo dos valores unitários dos itens agrupados no map, multiplicando a quantidade pelo valor e realizando o somatório com a estrutura de reduce do stream para otimizar e reduzir linhas de código.

Por fim, imprimi no console o resultado em um json formatado e com os dados ordenados por código da composição. 