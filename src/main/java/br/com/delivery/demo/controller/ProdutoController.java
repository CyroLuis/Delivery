package br.com.delivery.demo.controller;

import br.com.delivery.demo.dtos.ProdutoDto;
import br.com.delivery.demo.model.Produto;
import br.com.delivery.demo.repository.ProdutoRepositoy;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    ProdutoRepositoy produtoRepositoy;
// Esta action é responsavel por cadastrar novos produtos
    @PostMapping("/save")
    public ResponseEntity<Produto> produtoSave (@RequestBody @Valid ProdutoDto produtoDto){
        var produto = new Produto();
        BeanUtils.copyProperties(produtoDto,produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepositoy.save(produto));
    }
    //Esta action faz a buscar de todos os Produtos
    @GetMapping("/all")
    public  ResponseEntity<List<Produto>> mostrarTodos (){
        List<Produto> produtoList = produtoRepositoy.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(produtoList);
        }
      // Esta action buscar um Produto através do ID do mesmo
     @GetMapping("/buscar/{id}")
     public ResponseEntity<Object> buscarProduto(@PathVariable(value="id") Long id){
         Optional<Produto> produtoO = produtoRepositoy.findById(id);
         if (produtoO.isEmpty()){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
         }
         return ResponseEntity.status(HttpStatus.OK).body(produtoO.get());
     }
    //Esta action tem a função de editar um produto
   @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProduct (@PathVariable(value = "id") Long id, @RequestBody @Valid ProdutoDto produtoDto){
        Optional<Produto> produtoO = produtoRepositoy.findById(id);
        if (produtoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        var produto = produtoO.get();
        BeanUtils.copyProperties(produtoDto, produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepositoy.save(produto));
    }

    //essa action deleta um pedido por id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduto (@PathVariable(name = "id") Long id){
        Optional<Produto> produtoO = produtoRepositoy.findById(id);

        if (produtoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("PRODUTO NÃO EXISTE!");
        }
        var produto = produtoO.get();
        produtoRepositoy.delete(produto);
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso!");

    }
}
