//package com.Sample;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.Sample.Entity.Aluno;
//import com.Sample.Entity.Matricula;
//import com.Sample.repository.MatriculaRepository;
//
//public class Ma {
//
//	@Autowired
//	static
//	MatriculaRepository ma;		static Matricula m=new Matricula();
//
//public static void salva() {
//	Matricula m=new Matricula();
//
//m.setDescricao("teste");
//
//
//ma.save(m);
//
//}
//	
//	public static void main(String[] args) {	
//		
//	
//
//		Matricula m=new Matricula();
//		Aluno a=new Aluno();		Aluno a2=new Aluno();
//salva();
////a.setId(1L);
////a2.setId(2L);
////
////List<Aluno> alunos=new ArrayList<>();
////alunos.add(a);
////alunos.add(a2);
//
//		
//	}
//	
//	 public List aggregationByAll() {
//	  Aggregation aggregation = newAggregation(
//	    group("brand","salesyear").sum("numberOfCars").as("total"),
//	    sort(Sort.Direction.ASC, previousOperation(), "brand")    
//	  );
//
//	  AggregationResults groupResults = mongoTemplate.aggregate(
//	    aggregation, Car.class, SalesReport.class);
//	  
//	  List salesReport = groupResults.getMappedResults();
//
//	  return salesReport;
//	 }
//}
