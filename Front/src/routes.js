import React from 'react';

import Home from './pages/Home';
import Despesas from './pages/Despesas';
import Login from './pages/Login';
import Cadastro from './pages/Cadastro';
import Contato from './pages/Contato';
import Inicio from './pages/Inicio';

import { Switch, Route } from 'react-router-dom';

function Routes() {
    return(
        <Switch>
            <Route path="/" component={Home} exact />
            <Route path="/despesas" component={Despesas} />
            <Route path="/login" component={Login} />
            <Route path="/cadastro" component={Cadastro} />
            <Route path="/contato" component={Contato} />
            <Route path="/inicio" component={Inicio} />
        </Switch>
    );
}

export default Routes;