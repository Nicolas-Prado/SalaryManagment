/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import persistencia.FuncionarioDAO;
import persistencia.TabelaDAO;
import vo.Funcionario;
import vo.Tabela;
import vo.CalculaFolha;

@ManagedBean
@SessionScoped
/**
 *
 * @author nicol
 */
public class TelaSalariosBean implements Serializable {
    private FuncionarioDAO pm = new FuncionarioDAO();
    private TabelaDAO ps = new TabelaDAO();
    private Funcionario funcionario = new Funcionario();
    private Tabela tabela = new Tabela();
    private DataModel<Funcionario> funcionarios;
    private DataModel<CalculaFolha> calc;
    private List<CalculaFolha> cale;
    private CalculaFolha calculaf = new CalculaFolha();
    private Date dataa= new Date();

    public String salvafunc() {
        pm.salva(funcionario);
        funcionario = new Funcionario();
        return "index";
    }
    public String togo(){
       funcionario = new Funcionario(); 
       return "funcionario";
    }
    public String togo2(){
       tabela = ps.localiza(1);
       if(tabela==null){
           tabela=new Tabela();
       }
       return "tabelas";
    }

    public String salvatab() {
        ps.salva(tabela);
        return "";
    }
    
 
    
    public String togo3(){
        setFuncionarios((DataModel<Funcionario>) new ListDataModel(pm.pesquisa()));
        setCalc((DataModel<CalculaFolha>) new ListDataModel());
        setCale((List<CalculaFolha>) new ArrayList());
        tabela = ps.localiza(1);
        for(Funcionario a:getFuncionarios()){
            CalculaFolha calcu = new CalculaFolha();
            calcu.setFuncionario(a);
            calcu.setTabela(tabela);
            calcu.calcula();
            getCale().add(calcu);
        }
        calc= new ListDataModel(getCale());
        return "salarios";
    }
    
    public String forgo1(){
        setCalculaf(getCalc().getRowData());
        return "holerite";
    }
    
    /**
     * @return the pm
     */
    public FuncionarioDAO getPm() {
        return pm;
    }

    /**
     * @param pm the pm to set
     */
    public void setPm(FuncionarioDAO pm) {
        this.pm = pm;
    }

    /**
     * @return the ps
     */
    public TabelaDAO getPs() {
        return ps;
    }

    /**
     * @param ps the ps to set
     */
    public void setPs(TabelaDAO ps) {
        this.ps = ps;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the tabela
     */
    public Tabela getTabela() {
        return tabela;
    }

    /**
     * @param tabela the tabela to set
     */
    public void setTabela(Tabela tabela) {
        this.tabela = tabela;
    }

    /**
     * @return the funcionarios
     */
    public DataModel<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    /**
     * @param funcionarios the funcionarios to set
     */
    public void setFuncionarios(DataModel<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    /**
     * @return the calc
     */
    public DataModel<CalculaFolha> getCalc() {
        return calc;
    }

    /**
     * @param calc the calc to set
     */
    public void setCalc(DataModel<CalculaFolha> calc) {
        this.calc = calc;
    }

    /**
     * @return the cale
     */
    public List<CalculaFolha> getCale() {
        return cale;
    }

    /**
     * @param cale the cale to set
     */
    public void setCale(List<CalculaFolha> cale) {
        this.cale = cale;
    }

    /**
     * @return the calculaf
     */
    public CalculaFolha getCalculaf() {
        return calculaf;
    }

    /**
     * @param calculaf the calculaf to set
     */
    public void setCalculaf(CalculaFolha calculaf) {
        this.calculaf = calculaf;
    }

    /**
     * @return the dataa
     */
    public Date getDataa() {
        return dataa;
    }

    /**
     * @param dataa the dataa to set
     */
    public void setDataa(Date dataa) {
        this.dataa = dataa;
    }

    /**
     * @return the calc
     */
    
}
