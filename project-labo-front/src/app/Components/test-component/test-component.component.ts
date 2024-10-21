import { Component, OnInit } from '@angular/core';
import { MessageService } from '../../services/message.service';

@Component({
  selector: 'app-test-component',
  templateUrl: './test-component.component.html',
  styleUrl: './test-component.component.css',
})
export class TestComponentComponent implements OnInit {
  message!: string;

  constructor(private messageService: MessageService) {}

  ngOnInit(): void {
    this.messageService.getMessage().subscribe(
      (response) => {
        this.message = response.message; // Assigner la réponse du backend à la variable message
      },
      (error) => {
        console.error('Erreur lors de la récupération du message :', error);
      }
    );
  }
}
