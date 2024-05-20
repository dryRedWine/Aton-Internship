Для хранения данных был выбран MultiValuedMap - это словарь, 
который может хранить несколько значений с одинаковым ключом.
Так как это map удаление и добавление элементов осуществлялась через константу.
Алгоритмическая сложность поиска по полю в лучшем случае осуществляется 
за O(const), а в худшем за O(n)

## Example

```tsx
private final MultiValuedMap<Long, User> userByAccounts = new ArrayListValuedHashMap<>();
private final MultiValuedMap<String, User> userByName = new ArrayListValuedHashMap<>();
private final MultiValuedMap<Double, User> userByValue = new ArrayListValuedHashMap<>();
```
