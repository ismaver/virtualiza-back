package com.web.gestion;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import com.web.modelo.Calificacion;

import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;

import com.web.dao.DAOCalificacion;

@Stateless
public class GestionCalificacion{

    @Inject
    private DAOCalificacion calificacionDAO;

    private final Tracer tracer = GlobalTracer.get();

    public void agregarCalificacion(Calificacion calificacion){
        Span span = tracer.buildSpan("agregarCalificacion").start();
        try(Scope scope = tracer.scopeManager().activate(span)){
            Calificacion cal = calificacionDAO.read(calificacion.getCodigo());
            if(cal == null)
            calificacionDAO.create(calificacion);
            else
            calificacionDAO.update(calificacion);
        }catch(Exception e){
            span.log(e.getMessage());
            throw e;
        }finally{
            span.finish();
        }
    }

    public void actualizarCalificacion(Calificacion calificacion) throws Exception{
        Span span = tracer.buildSpan("actualizarCalificacion").start();
        try(Scope scope = tracer.scopeManager().activate(span)){
            Calificacion cal = calificacionDAO.read(calificacion.getCodigo());
            if(cal != null)
            calificacionDAO.update(calificacion);
            else
            throw new Exception("Calificacion no existe");
        }catch(Exception e){
            span.log(e.getMessage());
            throw e;
        }finally{
            span.finish();
        }
    }

    public void eliminarCalificacion(int id){
        Span span = tracer.buildSpan("eliminarCalificacion").start();
        try(Scope scope = tracer.scopeManager().activate(span)){
            calificacionDAO.delete(id);
        }catch(Exception e){
            span.log(e.getMessage());
            throw e;
        }finally{
            span.finish();
        }
    }

    public Calificacion buscarCalificacion(int codigo){
        Span span = tracer.buildSpan("buscarCalificacion").start();
        try(Scope scope = tracer.scopeManager().activate(span)){
            return calificacionDAO.read(codigo);
        }catch(Exception e){
            span.log(e.getMessage());
            throw e;
        }finally{
            span.finish();
        }
    }

    public List<Calificacion> listarCalificaciones(){
        Span span = tracer.buildSpan("listarCalificaciones").start();
        try(Scope scope = tracer.scopeManager().activate(span)){
            return calificacionDAO.getAll();
        }catch(Exception e){
            span.log(e.getMessage());
            throw e;
        }finally{
            span.finish();
        }
    }

}
