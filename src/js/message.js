document.getElementById('sendButton').addEventListener('click', () => {
    const input = document.getElementById('messageInput');
    const messageText = input.value.trim();
    if (messageText !== '') {
      const messageContainer = document.getElementById('messages');
      const newMessage = document.createElement('div');
      newMessage.classList.add('message', 'sent');
      newMessage.textContent = messageText;
      messageContainer.appendChild(newMessage);
      input.value = '';
      messageContainer.scrollTop = messageContainer.scrollHeight;
    }
  });