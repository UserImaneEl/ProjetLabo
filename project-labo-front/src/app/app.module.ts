import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestComponentComponent } from './Components/test-component/test-component.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { MessageService } from './services/message.service'; // Assurez-vous que ce chemin est correct

@NgModule({
  declarations: [AppComponent, TestComponentComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, HttpClient],
  providers: [MessageService],
  bootstrap: [AppComponent],
})
export class AppModule {}
