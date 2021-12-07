import React, { useContext } from 'react';

import { Context } from './Context/AuthContext';

import Home from './pages/Home';
import Despesas from './pages/Despesas';
import Receitas from './pages/Receitas';
import Login from './pages/Login';
import Cadastro from './pages/Cadastro';
import Contato from './pages/Contato';
import Inicio from './pages/Inicio';
import Movimentacao from './pages/Movimentacao'
import ContasAPagar from './pages/ContasAPagar';
import ContasAReceber from './pages/ContasAReceber';
import TokenTeste from './pages/TokenTeste';

import { Switch, Route, Redirect } from 'react-router-dom';

function Routes() {

    function CustomRoute({ isPrivate, ...rest }) {
        const { authenticated } = useContext(Context);

        if(isPrivate && !authenticated) {
            return <Redirect to="/login" />
        }

        return <Route { ...rest } />;
    }

    return(
        <Switch>
            <CustomRoute path="/login" component={Login} />
            <Route path="/" component={Home} exact />
            <CustomRoute isPrivate path="/despesas" component={Despesas} />
            <CustomRoute isPrivate path="/receitas" component={Receitas} />
            <Route path="/cadastro" component={Cadastro} />
            <Route path="/contato" component={Contato} />
            <CustomRoute isPrivate path="/inicio" component={Inicio} />
            <CustomRoute isPrivate path="/movimentacao" component={Movimentacao} /> 
            <CustomRoute path="/contasapagar" component={ContasAPagar} />
            <CustomRoute path="/contasareceber" component={ContasAReceber} />
            <CustomRoute path="/cu" component={TokenTeste} />

        </Switch>
    );
}

export default Routes;