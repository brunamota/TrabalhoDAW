
import { Route, BrowserRouter, Switch } from 'react-router-dom';
import Home from 'pages/home';
import Login from 'pages/Login/Login';
import Vagas from 'pages/Vagas'
import Empresa from 'pages/Empresa'
import Coordenador from 'pages/Coordenador'
import Alunos from 'pages/Alunos'

const Routes = () => {
  return (
    <BrowserRouter>
    <Switch>
      <Route component={Home} path="/" exact />
      <Route component={Login} path="/login" />
      <Route component={Vagas} path="/vagas" />
      <Route component={Empresa} path="/empresa" />
      <Route component={Coordenador} path="/coordenador" />
      <Route component={Alunos} path="/alunos" />
    </Switch>
    </BrowserRouter>
  );
}
export default Routes;

