package tarefas.api.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lista")
public class apiController {


    private List<String> tasks = new ArrayList<>();

    private ObjectMapper objectMapper;

    public apiController(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @GetMapping("/tasks")
    public ResponseEntity<String> createGet() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(tasks));
    }

    @PostMapping("/tasks")
    public ResponseEntity<Void> createPost(@RequestBody String task){
        tasks.add(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/tasks")
    public ResponseEntity<Void> createDelete(){
        tasks = new ArrayList<>();
        return ResponseEntity.ok().build();
    }
}
